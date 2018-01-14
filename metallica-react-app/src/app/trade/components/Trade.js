import React,{Component} from "react";
import TradeTable from "../containers/TradeTable";
import TradeSearch from "../containers/TradeSearch";
import TradeForm from "../containers/TradeForm";

export default class Trade extends Component{
    constructor(props) {
        super(props);        
    }

    componentDidMount(){
        this.props.actions.fetchRefData();
        this.props.actions.fetchTradeData();
    }
    
    render(){
        return (
            <div>
                 <div className="row thumbnail">
                     <TradeSearch></TradeSearch>
                </div>

                <div className="row thumbnail">
                     <div className="col-md-8">
                        <TradeTable />
                    </div>

                    <div className="col-md-4 thumbnail">
                        <TradeForm/>
                    </div>
                </div>
            </div>
        )
    }
}
