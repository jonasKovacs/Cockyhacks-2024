import './App.css';
import { useState } from "react";

function App() {

  const [value, setValue] = useState()
  const [data, setData] = useState([])
  const [selectedTitle, setSelectedTitle] = useState('')
  const [showDropdown, setShowDropdown] = useState(true)

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
  }

  return (
    <div className="App">
      <header className="App-header">
        <img src="logo.png"/>
      </header>
      <main className="App-main">
        <div className="search-container">
          <div className='search-inner'>
            <input type="text" onChange={onChange} value={value} className="search-input" placeholder="Enter class (ex. CSCE 145)" />
            <button onClick={() => onSearch(value)}> Search </button>
          </div>

          {showDropdown &&
          <div className="dropdown">
            {
              data.filter(item => item.code.startsWith(value)).map((item)=> <div
              onClick={()=>onSearch(item.code)}>
                  {item.code}
                </div>
            )}
          </div>
          }
          <div className="result">
            <p className='courseName'>{selectedTitle}</p>
            <p className='courseDescription'>Description</p>
          </div>
        </div>
      </main>
    </div>
  ); 
}

export default App;
