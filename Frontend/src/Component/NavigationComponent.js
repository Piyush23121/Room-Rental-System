import React from 'react'
import { Link } from 'react-router-dom'

const NavigationComponent = () => {
    return (
        <div>
            <nav className="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
                <div className="container-fluid">
                    <a className="navbar-brand" href="#">Online Rental System</a>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>

                    <div className="collapse navbar-collapse" id="navbarColor01">
                        <ul className="navbar-nav me-auto">
                            <li className="nav-item">
                                <Link className="nav-link" to="/home" style={{ color: 'indigo' }}>
                                    <a className="nav-link active" href="#">Home
                                        <span className="visually-hidden">(current)</span>
                                    </a></Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/PropertyList" style={{ color: 'indigo' }}> <a className="nav-link" href="#">Property List</a></Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/register/tenant" style={{ color: 'indigo' }}><a className="nav-link" href="#">Tenant Registration</a></Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/register/landlord" style={{ color: 'indigo' }}>    <a className="nav-link" href="#">Post a PRoperty</a></Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/Contactus" style={{ color: 'indigo' }}>     <a className="nav-link" href="#">Contact Us</a></Link>
                            </li>
                        </ul>
                        <ul className="navbar-nav">
                            <li className="nav-item">
                                <Link className="nav-link" to="/login/tenant" style={{ color: 'indigo' }}> <a className="btn btn-primary" href="#">Log In</a></Link>
                            </li>

                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    )
}

export default NavigationComponent
