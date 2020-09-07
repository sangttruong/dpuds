import React from "react";
import Link from "@docusaurus/Link";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCheckCircle } from "@fortawesome/free-regular-svg-icons";
import ReactPlayer from "react-player/youtube";
import { PrimaryButton } from "./buttons/PrimaryButton";

import "./valueProps.css";

const PropRow = (props) => (
    <div className="d-flex prop">
        <FontAwesomeIcon
            icon={faCheckCircle}
            size="2x"
            className="text--success"
        />
        {props.children}
    </div>
);

export const ValueProps = (props) => {
    return (
        <div className="hero-banner">
            <div className="container">
                <div className="row align-items-center justify-content-between m-5">
                    <div className="col-lg-4 order-2 order-lg-1 text-left">
                        <h3 className="heading font_large text-white">
                            Our mission is to transform the way knowledge is
                            shared by innovative teams.
                        </h3>
                        <h3 className="heading font_large text--white">
                            We belive that data should be bought and sold
                            responsibly, securely, and transparently.
                        </h3>
                        <Link
                            className="font_medium text--white"
                            to="https://identity.amphoradata.com/Register"
                        >
                            <PrimaryButton>Register for Free</PrimaryButton>
                        </Link>
                    </div>

                    <div className="col-lg-7 order-1 order-lg-2 col-video mb-5">
                        <ReactPlayer
                            url="https://youtu.be/rBt_743oT18"
                            width="100%"
                        />
                    </div>
                </div>
            </div>
        </div>
    );
};
