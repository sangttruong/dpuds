import React from "react";
import Link from "@docusaurus/Link";
import { PrimaryButton } from "./buttons/PrimaryButton";

import "./landing.css";

export const Landing = (props) => {
    return (
        <header className="hero hero-banner">
            <div className="landing container">
                <div className="row justify-content-center mt-2">
                    <div className="col col-9 banner font_large">
                        <h1 className="hero__title text-center text--white">
                            {props.siteConfig.title}
                        </h1>
                        <p className="hero__subtitle text-center text--white mt-5">
                            {props.siteConfig.tagline}
                        </p>
                    </div>
                    <div className="col actions">
                        <div className="row justify-content-center">
                            <div className="col-md-5 col-lg-6">
                                <Link to="https://identity.amphoradata.com/Login">
                                    <PrimaryButton className="w-100">
                                        Login
                                    </PrimaryButton>
                                </Link>
                            </div>
                            <div className="col-md-5 col-lg-6">
                                <Link to="https://identity.amphoradata.com/Register">
                                    <PrimaryButton className="w-100">
                                        Register
                                    </PrimaryButton>
                                </Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
    );
};
