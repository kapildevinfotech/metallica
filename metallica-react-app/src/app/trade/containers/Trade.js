import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import Trade from "../components/Trade";

import * as actions from "../state/action";

const mapStateToProps = (state) => {
    return {
        loading:state.tradeData.loading,
        trades: state.tradeData.trades
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        actions: bindActionCreators(actions,dispatch)
    }
}

export default connect(mapStateToProps, mapDispatchToProps) (Trade)