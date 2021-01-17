import React, {Component} from 'react';
import {GOOGLE_AUTH_URL} from '../constants/constants';
import {Redirect} from 'react-router-dom'

class Login extends Component {

    render() {
        if (this.props.authenticated) {
            return <Redirect
                to={{
                    pathname: "/",
                    state: {from: this.props.location}
                }}/>;
        }

        return (
            <div>
                <div>
                    <h1>Please let me in</h1>
                    <p>
                    <SocialLogin/>
                    </p>
                </div>
            </div>
        );
    }
}

class SocialLogin extends Component {
    render() {
        return (
            <div>
                <a href={GOOGLE_AUTH_URL}> Log in with Google </a>
            </div>
        );
    }
}

export default Login;