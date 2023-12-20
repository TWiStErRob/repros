module.exports = {
  collectCoverage: true,
  coverageProvider: "v8",
  coverageThreshold: {
    global: {
      lines: 100,
    },
  },
  testSequencer: "./sorted.js"
};
