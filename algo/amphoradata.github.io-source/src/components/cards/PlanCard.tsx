import React from "react";
import { PrimaryButton } from "../buttons/PrimaryButton";
import Link from "@docusaurus/Link";
import useBaseUrl from "@docusaurus/useBaseUrl";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCheckCircle } from "@fortawesome/free-regular-svg-icons";
import { faStar } from "@fortawesome/free-solid-svg-icons";

import "./plans.css";
// id: 0,
// title: "FREE",
// perUsers: "Individual",
// fee: "Nothing, its free!",
// isMostPopular: false,
// descriptions: {text: "", icon" ""}

export const PlanCard = (props) => {
    const plan = props.plan;
    return (
        <React.Fragment>
            <div className="col col--6">
                <div className="card plan-card ">
                    <div className="card__header">
                        <h3>{plan.title}</h3>
                    </div>
                    <div className="text--center">{plan.perUsers}</div>
                    <h4 className="text--center">{plan.fee}</h4>

                    <hr />
                    {props.isMostPopular ? (
                        <div className="text--center mb-2">
                            <FontAwesomeIcon
                                icon={faStar}
                                size="lg"
                                className="text--warning mr-1"
                            />
                            Most popular
                        </div>
                    ) : (
                        <br />
                    )}

                    <br />
                    {plan.descriptions.map((description) => (
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
                        <div className="plan-button">
                            <Link to={plan.actionLink}>
                                <PrimaryButton>{plan.actionName}</PrimaryButton>
                            </Link>
                        </div>
                    }
                </div>
            </div>
        </React.Fragment>
    );
};
