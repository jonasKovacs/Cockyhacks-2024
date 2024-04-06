import './App.css';
import { useState } from "react";

var data = require("./classes.json")

function App() {

  const [value, setValue] = useState()
  const [data, setData] = useState([])
  const onChange = (e) => {
    setValue(e.target.value)
    const data = require("./classes.json");
    setData(data)
  } 

  const onSearch=(searchTerm) => {
    setValue(searchTerm)
    console.log('search', searchTerm);
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
          <div className="dropdown">
            {
              data.filter(item => item.class.startsWith(value)).map((item)=> <div
              onClick={()=>onSearch(item.class)} >{item.class} </div>
            )}
          </div>
        </div>
      </main>
    </div>
  ); 
}

export default App;
