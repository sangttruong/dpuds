import * as React from "react";
import { Redirect } from "react-router";

//  THIS JUST REDIRETS TO THE OVERVIEW PAGE
const GlazeRedirect = () => {
    return <Redirect to="/glaze/overview" />;
};

export default GlazeRedirect;
