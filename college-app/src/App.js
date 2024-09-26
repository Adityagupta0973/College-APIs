import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import Home from './Home';  
import CollegeList from './CollegeList';
import CollegeDetails from './CollegeDetails';
import CourseList from './CourseList';  
import CourseDetails from './CourseDetails';  

function App() {
    return (
        <Router>
            <div className="container">
                {/* Bootstrap Navbar */}
                <nav className="navbar navbar-expand-lg navbar-light bg-light mb-4">
                    <div className="container-fluid">
                        <Link className="navbar-brand" to="/">My Education App</Link>
                        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                        </button>
                        <div className="collapse navbar-collapse" id="navbarNav">
                            <ul className="navbar-nav">
                                <li className="nav-item">
                                    <Link className="nav-link" to="/">Home</Link>
                                </li>
                                <li className="nav-item">
                                    <Link className="nav-link" to="/colleges">Colleges</Link>
                                </li>
                                <li className="nav-item">
                                    <Link className="nav-link" to="/courses">Courses</Link>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/" element={<CourseList />} />
                    <Route path="/" element={<CollegeList />} />
                    <Route path="/colleges/:collegeId" element={<CollegeDetails />} />
                    <Route path="/courses/:courseId" element={<CourseDetails />} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;
