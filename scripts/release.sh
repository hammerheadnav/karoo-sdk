#!/bin/bash -e

PUBLIC_REMOTE=public
INTERNAL_REMOTE=origin
BRANCH=0.x

git checkout $BRANCH
echo "Pulling current from $PUBLIC_REMOTE/$BRANCH"
git pull $PUBLIC_REMOTE $BRANCH > /dev/null
current_version=$(grep libraryVersion build.gradle | sed -e 's/.*"\(.*\)".*/\1/' | cut -d '-' -f 1)

echo "Current version: $current_version"
echo -n "Enter new version: "
read new_version
echo "New version: $new_version"

read -p "Releasing Karoo SDK ($new_version) with change log:"$'\n'"$(cat CHANGELOG.md)"$'\n'"Is this correct? [y/N]" answer
case "$answer" in
   [Yy]* ) ;;
   * ) echo "Aborting Karoo SDK release"; exit 1;;
esac

sed -i '' "s/$current_version/$new_version/" build.gradle
sed -i '' "s/$current_version/$new_version/" README.md
sed -i '' "s/$current_version/$new_version/" docs/index.md

./gradlew clean
./gradlew spotlesscheck
./gradlew sample:assemblerelease
./gradlew testReleaseUnitTest
./gradlew dokka

# Tagging and such
git add README.md build.gradle docs/index.md docs/$new_version
git commit -m "Karoo SDK Release $new_version"
git tag $new_version
git push $PUBLIC_REMOTE
git push $PUBLIC_REMOTE $new_version
git push $INTERNAL_REMOTE
git push $INTERNAL_REMOTE $new_version