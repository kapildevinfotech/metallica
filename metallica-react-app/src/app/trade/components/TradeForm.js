import React,{Component} from "react";

export default class TradeForm extends Component{
    constructor(props) {
        super(props);
    }

    

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
        
        return (
            <div className="row thumbnail">
                <form className="form-group">
                    <div className="row">
                        <div className="col-lg-6">
                            <label>Trade ID</label>  
                        </div>
                        <div className="col-lg-6">
                             
                        </div>
                    </div>

                    <div className="row margin-bottom-10" >
                        <div className="col-lg-4">
                            <label>Trade Date</label>
                        </div>
                        <div className="col-lg-8">
                            <input type="date" className="form-control" id="tradeDate"></input>  
                        </div>     
                    </div>

    
                    <div className="row margin-bottom-10">
                        <div className="col-lg-4">
                            <label>Commodity</label>
                        </div>
                        <div className="col-lg-8">  
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

                    <div className="row margin-bottom-10">
                        <div className="col-lg-4">
                            <label>Side</label>
                        </div> 
                        <div className="col-lg-8"> 
                            <input type="radio" value="BUY" name="side" /><label>BUY</label>
                            <input type="radio" value="SELL" name="side"/> <label>SELL</label>
                        </div>
                    </div>

                    <div className="row margin-bottom-10">
                        <div className="col-lg-4">
                            <label>Counter party</label>
                        </div>
                        <div className="col-lg-8">  
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

                    <div className="row margin-bottom-10">
                        <div className="col-lg-4">
                            <label>Price</label>
                        </div>
                        <div className="col-lg-8">  
                            <input type="text" id="price"></input>
                        </div>
                    </div>

                    <div className="row margin-bottom-10">
                        <div className="col-lg-4">
                            <label>Quantity</label>  
                        </div>
                        <div className="col-lg-8">
                            <input type="text" id="qty"></input>
                        </div>
                    </div>

                    <div className="row margin-bottom-10">
                        <div className="col-lg-4">
                             <label>Location</label>  
                        </div>
                        <div className="col-lg-8">
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

                    <div className="row">
                        <div className="row">
                            <div className="col-lg-6">
                            </div>
                            <div className="col-lg-6">
                                 <div className="col-lg-6">
                                    <button type="submit" className="btn btn-default">Cancel</button>
                                 </div>
                                 <div className="col-lg-6">
                                    <button type="submit" className="btn btn-default">Save</button>
                                </div>
                            </div>
                        </div>                        
                    </div>
                </form>
            </div>
        )
    }
}