import React from "react";
import Link from "@docusaurus/Link";
import { TabsComponent } from "./TabsComponent";
import { PrimaryButton } from "./buttons/PrimaryButton";

export const PageLayout = (props) => (
    <React.Fragment>
        <div className="container">
            <div className="row mt-12">
                <div className="col col--8">
                    <div className="font_large_caps">{props.heading}</div>
                    <div className="font_large">{props.subheading}</div>
                </div>
                <div className="col col--4">
                    {props.button || (
                        <Link to="https://identity.amphoradata.com/Register">
                            <PrimaryButton>Get Data</PrimaryButton>
                        </Link>
                    )}
                </div>
            </div>
            <TabsComponent tabs={props.tabs} />

            {props.children}
        </div>
    </React.Fragment>
);
