import React, { Component, PropTypes } from 'react';
import QuotationCard from './QuotationCard';
import timeAgoHandler from '../utils/timeAgoHandler'
import axios from 'axios';

class QuotationCardContainer extends Component {

    constructor(props) {
        super(props);
        this.key = 'row' + props.id + props.title;
        const appState = localStorage.getItem(this.key);
        if (appState) {
            this.state = JSON.parse(appState)
        } else {
            this.state = { quote: 'Loading', timeAgo: 'Recently', date: Date.now() };
            this.saveCardState();
        }
    }

    componentDidMount() {
        if (this.state.quote == 'Loading') {
            axios.get(this.props.url).then((response) => {
                this.setState({ quote: response.data.quote });
                this.saveCardState();
            }).catch((error) => {
                this.setState({ quote: 'Not available' });
                this.saveCardState();
            })
        }

        setInterval(() => {
            this.setState({ timeAgo: timeAgoHandler(this.state.date) });
            this.saveCardState();
        }, 15000);
    }

    saveCardState() {
        localStorage.setItem(this.key, JSON.stringify(this.state));
    }

    render() {
        return (
            <QuotationCard title={this.props.title} quote={this.state.quote} timeAgo={this.state.timeAgo} />
        );
    }
}

QuotationCardContainer.propTypes = {
    title: PropTypes.string.isRequired,
    url: PropTypes.string.isRequired,
    id: PropTypes.number.isRequired
};

export default QuotationCardContainer;