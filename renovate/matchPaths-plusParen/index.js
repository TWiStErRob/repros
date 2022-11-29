const minimatch = require("minimatch");

function test(rulePath, packageFile) {
	let includes = packageFile.includes(rulePath);
	let match = minimatch(packageFile, rulePath, { dot: true });
	const result = includes || match;
	console.log(`${packageFile}.includes(${rulePath}) = ${includes} || minimatch(${rulePath}, ${packageFile}) = ${match} => ${result}`);
}

console.log("raw");
test("gradle/agp.versions.toml", "gradle/agp.versions.toml");
test("docs/examples/release/**", "docs/examples/release/gradle/wrapper/gradle-wrapper.properties");
test("docs/debug/agp*-gradle*/gradle/wrapper/gradle-wrapper.properties", "docs/debug/agp333-gradle4103/gradle/wrapper/gradle-wrapper.properties");
console.log("+()");
test("+(gradle/agp.versions.toml)", "gradle/agp.versions.toml");
test("+(docs/examples/release/**)", "docs/examples/release/gradle/wrapper/gradle-wrapper.properties");
test("+(docs/debug/agp*-gradle*/gradle/wrapper/gradle-wrapper.properties)", "docs/debug/agp333-gradle4103/gradle/wrapper/gradle-wrapper.properties");
