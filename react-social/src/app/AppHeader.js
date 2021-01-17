import React, {Component} from 'react';
import {Link, NavLink} from 'react-router-dom';
import './App.Header.css';

class AppHeader extends Component {
    render() {
        return (
            <header >
                <div >
                    <div >
                        <Link to="/">Main Page</Link>
                    </div>
                    <div >
                        <nav>
                                { this.props.authenticated ? (
                                    <ul>
                                        <li>
                                            <NavLink to="/profile">Profile</NavLink>
                                        </li>
                                        <li>
                                            <NavLink to="/dataNotSafe">Get data from backend</NavLink>
                                        </li>
                                        <li>
                                            <a onClick={this.props.onLogout}>Logout</a>
                                        </li>
                                    </ul>
                                ): (
                                    <ul>
                                        <li>
                                            <NavLink to="/login">Login</NavLink>        
                                        </li>
                                        <li>
                                            <NavLink to="/dataNotSafe">Get data from backend</NavLink>
                                        </li>
                                    </ul>
                                )}
                        </nav>
                    </div>
                </div>
            </header>
        )
    }
}

export default AppHeader;