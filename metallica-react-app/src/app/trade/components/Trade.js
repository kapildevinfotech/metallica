import React,{Component} from "react";
import TradeTable from "./TradeTable";
import TradeSearch from "../containers/TradeSearch";
import TradeForm from "../containers/TradeForm";

export default class Trade extends Component{
    constructor(props) {
        super(props);
    }

    componentDidMount(){
        this.props.actions.fetchRefData();
    }
    
    render(){
        return (
            <div>
                 <div className="row">
                     <TradeSearch></TradeSearch>
                </div>

                <div className="row">
                     <div className="col-md-8">
                        <TradeTable />
                    </div>

                    <div className="col-md-4">
                        <TradeForm/>
                    </div>
                </div>
            </div>
        )
    }
}
