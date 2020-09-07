import React from "react";
import classnames from "classnames";
import Layout from "@theme/Layout";
import styles from "./styles.module.css";
import { faArrowAltCircleLeft } from "@fortawesome/free-regular-svg-icons";
import { PlanCard } from "../components/cards/PlanCard";

const pricing = (props) => {
    const prices = [
        {
            id: 0,
            title: "DATA PRODUCTS",
            perUsers: "1-3 users",
            fee: "Only pay for the data you use",
            isMostPopular: false,
            descriptions: [
                { text: "Buy data from Amphora Marketplace" },
                { text: "Request new data products from  community" },
                { text: "Sell and share your own insights" },
                { text: "Unlimited data downloads" },
                { text: "Personal dashboard" },
                { text: "10GB of storage" },
                { text: "SDKs and sample code" },
                { text: "Documentation and online tutorials" },
                { text: "Community support" },
            ],
            actionLink: "https://identity.amphoradata.com/Register",
            actionName: "Register for free",
        },
        {
            id: 1,
            title: "GLAZE",
            perUsers: "Coming soon",
            fee: "Single-click infrastructure for data businesses",
            isMostPopular: false,
            actionLink: "mailto:contact@amphoradata.com",
            actionName: "Learn more",
            descriptions: [
                { text: "Drop-in code to sell data through your own website" },
                { text: "Sell your own insights on Amphora Marketplace" },
                { text: "Buy data from Amphora Marketplace" },
                { text: "Set custom data usage T&Cs and access controls" },
                { text: "Customer identity management" },
                { text: "Seamless payments handling" },
                { text: "Usage and ETL monitoring and reporting" },
                { text: "Instantly deployable" },
                { text: "Admin controls and audit logs" },
                { text: "10TB of storage" },
                { text: "Interactive training, set-up and support" },
            ],
        },
    ];
    return (
        <Layout title="Pricing">
            <div
                className={classnames(
                    "container container--fluid",
                    styles.presentationContainer
                )}
            >
                <div
                    className={classnames(
                        "mt-4 mr-2 row",
                        styles.justifyContentCenter
                    )}
                >
                    {prices.map((price) => (
                        <PlanCard
                            key={price.id}
                            isMostPopular={price.isMostPopular}
                            plan={price}
                        />
                    ))}
                </div>
            </div>
        </Layout>
    );
};

export default pricing;
