https://github.com/jekyll/jekyll-feed/issues/269

## Repro
```shell
bundle install
bundle exec jekyll build
```

## Expected
no warnings

## Actual
```
Kramdown warning: Footnote definition for '1' on line 4 is unreferenced - ignoring
```
