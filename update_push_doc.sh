#!/bin/sh

## Uppdates the Javadocs hosted at
## http://ushahidi.github.io/Crowdmap-Java/javadoc/com/crowdmap/java/sdk/package-summary.html

DOCS=docs
JAVADOCS=build/javadoc

set -e

trap "rm -rf $PWD/$DOCS" EXIT

rm -rf $DOCS $JAVADOCS
git clone git@github.com:ushahidi/Crowdmap-Java.git $DOCS -b gh-pages
./gradlew doc
VERSION=$(basename $JAVADOCS/*)
rsync -f 'exclude .git' -r --delete $JAVADOCS/$VERSION $DOCS/javadoc
cd $DOCS
git commit -m "javadocs for $VERSION" -a --allow-empty
git add .
git commit --amend -a -m "javadocs for $VERSION" --allow-empty
git diff origin/gh-pages --summary --exit-code || git push origin gh-pages