const Sequencer = require('@jest/test-sequencer').default;

class CustomSequencer extends Sequencer {
  sort(tests) {
    return Array.from(tests).sort((a, b) => a.path < b.path? 1 : -1);
  }
}

module.exports = CustomSequencer;
