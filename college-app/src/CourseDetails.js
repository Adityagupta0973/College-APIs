import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const CourseDetails = () => {
    const { courseId } = useParams(); // Extract the courseId from the URL
    const [course, setCourse] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        axios.get(`http://localhost:8080/courses/${courseId}`)
            .then(response => {
                setCourse(response.data);
                setLoading(false);
            })
            .catch(error => {
                setError('Error fetching course details.');
                setLoading(false);
            });
    }, [courseId]);

    if (loading) return <p>Loading...</p>;
    if (error) return <p>{error}</p>;
    if (!course) return <p>Course not found.</p>;

    return (
        <div>
            <h2>{course.name}</h2>
            <p>Course Fee: {course.fee}</p>
            <p>Course Duration: {course.duration}</p>
            <p>Associated College: {course.college ? course.college.name : 'N/A'}</p>
        </div>
    );
};

export default CourseDetails;
