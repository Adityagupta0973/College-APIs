import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

const CollegeList = () => {
    const [colleges, setColleges] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        axios.get('http://localhost:8080/colleges')
            .then(response => {
                setColleges(response.data);
                setLoading(false);
            })
            .catch(error => {
                setError('Error fetching colleges.');
                setLoading(false);
            });
    }, []);

    if (loading) return <p>Loading...</p>;
    if (error) return <p>{error}</p>;

    return (
        <div>
            <h2>College List</h2>
            <ul>
                {colleges.map(college => (
                    <li key={college.id}>
                        <h3>{college.name}</h3>
                        <p>Accommodation: {college.accommodationType}</p>
                        <p>Accommodation Fee: {college.accommodationFee}</p>
                        <Link to={`/colleges/${college.id}`}>View Details</Link>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default CollegeList;
