const base = "https://app.amphoradata.com/Discover";
const org = "7b429e6c-2885-49cf-994d-4775ae170d64";
const qs = (labels, take) => `Q.OrgId=${org}&Q.Labels=${labels}&Q.Take=${take}`;

export const products = [
    {
        title: "Static composition",
        imageUrl: "img/soil_composition.PNG",
        description: `Estimated soil composition up to 2 meters for any location in
                Australia. Resolution is 90 m. 1000s of locations available for
                free, more available upon request.`,
        link: `${base}?${qs("Soil", 120)}&handler=MapView`,
    },
    {
        title: "Real-time moisture",
        imageUrl: "img/soil_moisture_index.PNG",
        description: `  Remote sensing of soil moisture in surface layer with 1 week
                delay. Resolution is 30m. Any global location available for free
                on request.
            `,
    },
];
