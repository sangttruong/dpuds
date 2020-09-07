import React from "react";
import { PrimaryButton } from "../buttons/PrimaryButton";
import Link from "@docusaurus/Link";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCheckCircle } from "@fortawesome/free-regular-svg-icons";

import "./plans.css";

export const GlazeCard = (props) => {
    const info = props.info;
    return (
        <React.Fragment>
            <div className="col">
                <div className="card plan-card">
                    <div className="row--centre">
                        <img src={info.imageUrl} alt={info.title} width="400" />
                    </div>
                    <hr />
                    <div className="row--centre">
                        <div className="card__header">
                            <h2 className="text--center">{info.fee}</h2>
                        </div>
                    </div>
                    {info.descriptions.map((description) => (
                        <div key={description.text} className="d-flex mb-2">
                            <FontAwesomeIcon
                                icon={description.icon || faCheckCircle}
                                size="lg"
                                className="text--primary mr-1"
                            />

                            <div className="text--left">{description.text}</div>
                        </div>
                    ))}
                    {
                        <div className="info-button">
                            <a href={info.actionLink2} download>
                                <PrimaryButton>
                                    {info.actionName2}
                                </PrimaryButton>
                            </a>
                        </div>
                    }
                    <hr />
                    {
                        <div className="plan-button">
                            <Link to={info.actionLink}>
                                <PrimaryButton>{info.actionName}</PrimaryButton>
                            </Link>
                        </div>
                    }
                </div>
            </div>
        </React.Fragment>
    );
};
