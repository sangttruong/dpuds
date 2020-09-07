import React from "react";
import Link from "@docusaurus/Link";
import { PrimaryButton } from "./buttons/PrimaryButton";

export const SellData = () => {
    return (
        <div className="container">
            <div className="row align-items-center justify-content-center">
                <div className="col-md-5 order-1 order-md-2 text-center">
                    <img
                        className="img-fluid"
                        alt="List Sell Get Paid"
                        src="img/marketing/list_sell_get_paid.png"
                        width="500px"
                    />
                </div>
                <div className="col-md-5 order-2 order-md-1 text-center">
                    <div className="font_large mt-5">
                        Do you have valuable data but not sure how to sell it?
                    </div>
                    <div className="font_large mt-3">
                        List your data today in minutes.
                    </div>
                    <div className="font_large mt-3">
                        We handle payments, security, storage, identity
                        management and more.
                    </div>
                    <div className="m-3">
                        <Link to="/selldata">
                            <PrimaryButton className="w-100">
                                Start selling
                            </PrimaryButton>
                        </Link>
                    </div>
                </div>
            </div>
        </div>
    );
};
