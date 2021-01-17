import React, {Component} from 'react';
import {ACCESS_TOKEN, API_BASE_URL} from "../constants/constants";
import axios from 'axios';

class BackendRequest extends Component {
    constructor(props) {
        super(props);
        this.state = {data: "Request not send"};
    }

    sendRequest = () => {
        this.request({
            url: API_BASE_URL + "/data",
            method: 'GET'
        });
    }

    request = (options) => {
        const headers = new Headers({});


        axios.get(options.url, {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + localStorage.getItem(ACCESS_TOKEN)
            }
        }).then(response =>
                this.setState({data: response.data})
            ).catch((error) => {
            this.setState({data: JSON.stringify(error.response)});
        });
    };


    render() {
        return (
            <div>
                <h1>
                    Ups unsafe endpoint
                </h1>
                <button onClick={this.sendRequest}>
                    Get data
                </button>
                <div>
                    {this.state.data}
                </div>
            </div>
        );
    }
}

export default BackendRequest;