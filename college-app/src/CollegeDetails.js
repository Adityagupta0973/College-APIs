import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const CollegeDetails = () => {
    const { collegeId } = useParams();
    const [college, setCollege] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        axios.get(`http://localhost:8080/colleges/${collegeId}`)
            .then(response => {
                setCollege(response.data);
                setLoading(false);
            })
            .catch(error => {
                setError('Error fetching college details.');
                setLoading(false);
            });
    }, [collegeId]);

    if (loading) return <p>Loading...</p>;
    if (error) return <p>{error}</p>;
    if (!college) return <p>College not found.</p>;

    return (
        <div>
            <h2>{college.name}</h2>
            <p>Accommodation Type: {college.accommodationType}</p>
            <p>Accommodation Fee: {college.accommodationFee}</p>

            <h3>Courses Offered</h3>
            <ul>
                {college.courses && college.courses.length > 0 ? (
                    college.courses.map((course) => (
                        <li key={course.id}>
                            <h4>{course.name}</h4>
                            <p>Fee: {course.fee}</p>
                            <p>Duration: {course.duration}</p>
                        </li>
                    ))
                ) : (
                    <p>No courses available for this college.</p>
                )}
            </ul>
        </div>
    );
};

export default CollegeDetails;
