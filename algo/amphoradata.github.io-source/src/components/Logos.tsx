import React from "react";

const imgStyle: React.CSSProperties = {
    maxHeight: "10rem",
};
interface Supporter {
    imgPath: string;
    website: string;
}
const supporters: Supporter[] = [
    {
        imgPath: "/img/logos/Sentek.png",
        website: "https://sentektechnologies.com/",
    },
    {
        imgPath: "/img/logos/UNSW_founders.png",
        website: "https://www.founders.unsw.edu.au/",
    },
    {
        imgPath: "/img/logos/YERC.png",
        website: "https://www.yellowstoneresearch.org/",
    },
    {
        imgPath: "/img/logos/microsoft.png",
        website: "https://www.microsoft.com/en-us/ai/ai-for-earth",
    },
];

export const Logos = () => {
    return (
        <div className="container">
            <div className="row mt-4">
                <div className="col heading font_large text--black text--center">
                    <h3>A few of our partners and customers</h3>
                </div>
            </div>
            <div className="row text-center align-items-center ml-2 mr-2">
                {supporters.map((s, i) => (
                    <div key={i} className="col-lg-3 col-sm-6 col-6">
                        <a href={s.website}>
                            <img
                                style={imgStyle}
                                className="img-fluid"
                                src={s.imgPath}
                            />
                        </a>
                    </div>
                ))}
            </div>
        </div>
    );
};
