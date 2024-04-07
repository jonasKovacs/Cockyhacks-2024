import React, { useState, useEffect } from 'react';

function DataFetchingComponent() {
    const [data, setData] = useState(null);

    useEffect(() => {
        fetch('http://localhost:8080/api/data')
            .then(response => response.json())
            .then(data => setData(data))
            .catch(error => console.error('Error fetching data:', error));
    }, []); // Empty dependency array means this effect runs once on mount

    return (
        <div>
            {/* Render your data here */}
            {data && <div>{JSON.stringify(data)}</div>}
        </div>
    );
}