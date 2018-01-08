import React,{Component} from "react";

export default class TradeSearch extends Component{
    render(){
        let {refData,loading} = this.props;
        
        if(loading==undefined || loading==true){
            return (
                <div>
                    {loading}
                </div>
            )
        }
        
        const commodityList=refData.commodity;
        const locationList=refData.location;
        const counterpartyList=refData.counterparty;

        return(
                <div className="row thumbnail">
                <form className="form-group">
                    <div className="col-md-3">
                        <div className="row">
                            <label>Trade Date</label>
                        </div>
                        <div className="row">
                            <div className="col-md-5">
                                <input type="date" className="form-control" id="tradeToDate"></input>
                            </div> 
                             <div className="col-md-2">
                                <label> to </label>
                            </div>
                            <div className="col-md-5">
                                <input type="date" className="form-control" id="tradeFromDate"></input>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-1">
                        <div className="row">
                            <label>Commodity</label>  
                        </div>
                        <div className="row">
                            <select id="commodity" name="commodity">
                                {  
                                    commodityList.map( commodity => (
                                        <option key={commodity._id} value={commodity.code}>
                                            {commodity.code}
                                        </option>
                                    ))
                                }
                            </select> 
                        </div>
                    </div>
                    
                    <div className="col-md-2">
                        <div className="row">
                            <label>SIDE</label>
                        </div>
                        <div className="row">   
                            <div className="col-md-6"> 
                                <input type="checkbox" id="buy" name="side" value="BUY"/>
                                <label>BUY</label>
                            </div>
                            <div className="col-md-6"> 
                                <input type="checkbox" id="sell" name="side" value="SELL"/>
                                <label>SELL</label>
                            </div>
                        </div>
                    </div>

                    <div className="col-md-2">
                        <div className="row">
                            <label>Counter party</label>  
                        </div>
                        <div className="row">
                        <select id="counterparty" name="counterparty">
                            {  
                                counterpartyList.map( counterparty => (
                                    <option key={counterparty._id} value={counterparty.code}>
                                        {counterparty.code}
                                    </option>
                                ))
                            }
                            </select>
                        </div>
                    </div>

                    <div className="col-md-2">
                        <div className="row">
                             <label>Location</label>
                        </div>
                        <div className="row">       
                        <select id="location" name="location">
                            {  
                                locationList.map( location => (
                                    <option key={location._id} value={location.code}>
                                        {location.code}
                                    </option>
                                ))
                            }
                            </select> 
                        </div>
                    </div>
                    <div className="col-md-2">
                        <div className="col-md-6">
                            <button type="submit" className="btn btn-default">Clear</button>
                        </div>
                        <div className="col-md-6">
                            <button type="submit" className="btn btn-default">Search</button>
                        </div>
                    </div>
                </form>
            </div>
        )
    }
}