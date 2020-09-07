import React from "react";
import Link from "@docusaurus/Link";
import { PrimaryButton } from "./buttons/PrimaryButton";

export const BuyData = (props) => {
    return (
        <div className="container">
            <div className="row align-items-center justify-content-center">
                <div className="col-md-5 text-center">
                    <img
                        className="img-fluid"
                        alt="Discover Buy Use"
                        src="img/marketing/discover_buy_use.png"
                        width="500px"
                    />
                </div>
                <div className="col-md-5 text-center">
                    <div className="font_large mt-5">
                        Looking for cheap and easy to use data?
                    </div>
                    <div className="font_large mt-3">
                        Discover and buy data from our Marketplace in 30
                        seconds.
                    </div>
                    <div className="font_large mt-3">
                        Only buy the data you need - no platform fees or lock-in
                        contracts!
                    </div>
                    <div className="m-3">
                        <Link
                            className="font_medium text--white"
                            to="data/vegetation"
                        >
                            <PrimaryButton className="w-100 mb-5">
                                Discover data
                            </PrimaryButton>
                        </Link>
                    </div>
                </div>
            </div>
        </div>
    );
};
