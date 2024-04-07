import './App.css';
import { useState } from "react";
import { Rating } from 'react-simple-star-rating'

function App() {

  const [value, setValue] = useState('')
  const [data, setData] = useState([])
  const [selectedTitle, setSelectedTitle] = useState('')
  const [showDropdown, setShowDropdown] = useState(true)
  const [showResult, setShowResult] = useState(false)

  var desc145 = 'Problem-solving, algorithmic design, and programming. Two lecture hours and four laboratory hours per week. Open to all majors. Carolina Core ARP.'
  var review1 =  'This course was great for basic intro programming concepts and algorithms'
  var review2 = 'Perfect course for an intro to Java. Homeworks arent bad but can be time consuming. Grades made up of . Definitely recommend this class!'
  var review3 = 'Great class. Take JJ !!!'

  const onChange = (e) => {
    setShowDropdown(true)
    setValue(e.target.value)
    const data = require("./testing.json");
    setData(data)
  }

  const onSearch=(searchTerm) => {
    setValue(searchTerm)
    console.log('search', searchTerm);
    const selectedItem = data.find(item => item.code === searchTerm);
    if (selectedItem) {
      setSelectedTitle(selectedItem.title);
    } else {
      setSelectedTitle('');
    }
    setShowDropdown(false);
    setShowResult(true)
  }

  return (
    <div className="App">
      <style>
        @import url('https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,100..900;1,100..900&display=swap')
      </style>
      <header className="App-header">
        <img src="logo.png"/>
      </header>
      <main className="App-main">
        <div className="search-container">
          <div className='search-inner'>
            <p className="searchText">Search Course</p>
            <input type="text" onChange={onChange} value={value} className="search-input" placeholder="Enter class (ex. CSCE 145)" />
            <button onClick={() => onSearch(value)}> Search </button>
            
          </div>
          {showDropdown &&
          <div className="dropdown">
            {
              data.filter(item => item.code.startsWith(value)).map(
                (item)=> 
                <div onClick={()=>onSearch(item.code)} className="dropdown-item">
                  {item.code}
                </div>
            )}
          </div>
          }
          {showResult &&
            <div className="result">
              <p className='courseCode'>{value}</p>
                <p className='courseName'>{selectedTitle}</p>
              <p className='courseDescription'><strong>Description: </strong>{desc145}<p>NOTE: This class uses Java.</p></p>
              {value =='CSCE 145' &&
                <div className='courseReviews'>  
                <button className='addReview'>Add Review</button>
                <p className='reviews'><strong>Reviews:</strong></p>
                <hr></hr>
                <div className = 'reviewList'>
                  <p className='review1'><strong>User6289: </strong>{review1}</p>
                    <p><strong>Professor:</strong> Unknown</p>
                  <hr></hr>
                  <p className='review2'><strong>Anonymous: </strong>{review2}</p>
                    <p><strong>Professor:</strong> JJ Shepherd</p>
                  <hr></hr>
                  <p className='review3'><strong>Go_Cocks2435: </strong>{review3}</p>
                    <p><strong>Professor:</strong> JJ Shepherd</p>
                  <hr></hr>
                </div>
              </div>
              } 
            </div>
          }
        </div>
      </main>
    </div>
  ); 
}

export default App;
