import React, { useEffect, useState } from 'react';
import axios from 'axios';
// import { Link } from 'react-router-dom';

const CourseList = () => {
    const [courses, setCourses] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        axios.get('http://localhost:8080/courses')
            .then(response => {
                setCourses(response.data);
                setLoading(false);
            })
            .catch(error => {
                setError('Error fetching courses.');
                setLoading(false);
            });
    }, []);

    if (loading) return <p>Loading...</p>;
    if (error) return <p>{error}</p>;

    return (
        <div>
            <h2>Course List</h2>
            <ul>
                {courses.map(course => (
                    <li key={course.id}>
                        <h4>{course.name}</h4>
                        <p>Fee: {course.fee}</p>
                        <p>Duration: {course.duration}</p>
                        
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default CourseList;
