const base = "https://app.amphoradata.com/Discover";
const org = "7b429e6c-2885-49cf-994d-4775ae170d64";
const qs = (labels, take) =>
    `Q.OrgId=${org}&Q.Labels=${labels}&Q.Take=${take || 100}&handler=ListView`;

const products = [
    {
        title: "Livestock prices",
        imageUrl: "img/mla_image.PNG",
        description: `  Real-time data of major livestock indices in Australia. Major
                indices ready to use for free, more available on request.`,
        link: `${base}?${qs("Meat")}`,
    },
    {
        title: "Electricity price forecasts",
        imageUrl: "img/electricity_image.PNG",
        description: ` Real-time 36 hour electricity price forecasts for QLD, SA, TAS,
                NSW, and VIC. Ready for use for free`,
        link: `${base}?${qs("Electricity")}`,
    },
];

export { products };
