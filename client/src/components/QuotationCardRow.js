import React, { PropTypes } from 'react';
import QuotationCardContainer from './QuotationCardContainer';

const QuotationCardRow = props => {
    return (
        <div className='flexdiv'>
            <div className='card'>
                <QuotationCardContainer title='Dollar' url='http://localhost:8080/api/quotation/dollar' id={props.id} />
            </div>
            <div className='card'>
                <QuotationCardContainer title='Peso' url='http://localhost:8080/api/quotation/peso' id={props.id} />
            </div>
            <div className='card'>
                <QuotationCardContainer title='Real' url='http://localhost:8080/api/quotation/real' id={props.id} />
            </div>
        </div>
    );
};

QuotationCardRow.propTypes = {
    id: PropTypes.number.isRequired
}

export default QuotationCardRow;