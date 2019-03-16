https://github.com/jekyll/jekyll-feed/issues/269
https://github.com/jekyll/jekyll/issues/7576

## Repro
```shell
bundle install
bundle exec jekyll build --safe
```

## Expected
no warnings

## Actual
```
Kramdown warning: Footnote definition for '1' on line 4 is unreferenced - ignoring
```
