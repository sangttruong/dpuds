import React from "react";
import useBaseUrl from "@docusaurus/useBaseUrl";

import "./data-products.css";

export const DataProducts = ({ products }) => {
    return (
        <React.Fragment>
            <div>
                {products && products.length && (
                    <section className="data-products">
                        <div className="container">
                            {products.map((props, idx) => (
                                <Product key={idx} {...props} />
                            ))}
                        </div>
                    </section>
                )}
            </div>
        </React.Fragment>
    );
};

function Product({ imageUrl, title, description, link }) {
    const imgUrl = useBaseUrl(imageUrl);
    return (
        <div className="row">
            <div className="col">
                {imgUrl && (
                    <div
                        className="text--center"
                        style={{ paddingLeft: "30px", paddingRight: "30px" }}
                    >
                        <img src={imgUrl} alt={title} />
                    </div>
                )}
            </div>
            <div className="col">
                <h3 className="font_large">{title}</h3>
                <p className="font_medium">{description}</p>
                {link && (
                    <a target="_blank" href={link}>
                        View Data
                    </a>
                )}
            </div>
        </div>
    );
}
