import * as React from "react";
import { Redirect } from "react-router";

//  THIS JUST REDIRETS TO THE VEG PAGE
const RedirectToVeg = () => {
    return <Redirect to="/data/vegetation" />;
};

export default RedirectToVeg;
