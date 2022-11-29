const glob = require('@actions/glob');

const patterns = [
   'a/**/*.txt',
   '!d.*', // Won't exclude because it's relative.
]
async function start() {
        const globber = await glob.create(patterns.join('\n'))
        const files = await globber.glob()

        console.log("Found!")
        console.log(files)
}

start()
