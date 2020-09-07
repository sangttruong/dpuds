import React from "react";
import Link from "@docusaurus/Link";
import classnames from "classnames";

import "./buttons/buttons.css";

// glaze tabs

export const GlazeTabs = [
    {
        to: "/glaze/overview",
        name: "Overview",
    },
];

// find data tabs
const catalog = "data";
export const DataTabs = [
    {
        to: `/${catalog}/vegetation`,
        name: "Vegetation",
    },
    {
        to: `/${catalog}/weather`,
        name: "Weather",
    },
    {
        to: `/${catalog}/water`,
        name: "Water",
    },
    {
        to: `/${catalog}/soil`,
        name: "Soil",
    },
    {
        to: `/${catalog}/economic`,
        name: "Economic",
    },
];

// window will not be defined in the build step.
const isClient = typeof window !== "undefined";

export const TabsComponent = (props) => {
    let activePath = "";

    if (isClient && window && window.location && window.location.pathname) {
        activePath = window.location.pathname.replace(/\/$/, "");
    }

    return (
        <React.Fragment>
            <div
                className={classnames(
                    "row row--no-gutters mt-4 text--center tabs_row"
                )}
            >
                {props.tabs.map((m) => (
                    <div key={m.to} className="col">
                        <Link
                            className="font_medium_bold text--black"
                            to={m.to}
                        >
                            <div
                                className={classnames(
                                    "buttons_tab",
                                    m.to === activePath && "tab_active"
                                )}
                            >
                                {m.name}
                            </div>
                        </Link>
                    </div>
                ))}
            </div>
            {props.children}
        </React.Fragment>
    );
};
