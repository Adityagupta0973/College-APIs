import React from 'react';
import CollegeList from './CollegeList';
import CourseList from './CourseList';

const Home = () => {
    return (
        <div>
            <h1>College and Course Lists</h1>
            <div style={{ display: 'flex', justifyContent: 'space-around' }}>
                <div>
                    <h2>Colleges</h2>
                    <CollegeList />
                </div>

                <div>
                    <h2>Courses</h2>
                    <CourseList />
                </div>
            </div>
        </div>
    );
};

export default Home;
