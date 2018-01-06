import React from "react";
import PropTypes from "prop-types";

export default function Footer(props){
    return (
        <div>
            <hr/>
            Copyrights @{props.year}, {props.company}
        </div>
    )
}

Footer.propTypes={
    year : PropTypes.number.isRequired, //Mandatory
    company : PropTypes.string //optional props
}

Footer.defaultProps={
    company:"sapient Inc."
}