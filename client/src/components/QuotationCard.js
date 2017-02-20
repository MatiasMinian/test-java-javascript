import React, { PropTypes } from 'react';
import { Card, CardTitle, CardText } from 'material-ui/Card';

const QuotationCard = props => {
    return (
        <Card>
            <CardTitle title={props.title} />
            <CardText>{props.quote}</CardText>
            <CardText>{props.timeAgo}</CardText>
        </Card>
    );
};

QuotationCard.propTypes = {
    title: PropTypes.string.isRequired,
    quote: PropTypes.oneOfType([PropTypes.string, PropTypes.number]),
    timeAgo: PropTypes.string
};

export default QuotationCard;