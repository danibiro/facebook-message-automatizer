if [ ! $# -eq 1 ]
then
    echo Usage: "$0" path_to_project
    exit 1
fi

if [ ! -d "$1" ]
then
    echo "$1" is not a valid directory
    exit 1
fi

if [ ! -e "$1/src/test/java/fbmessage/tests/MessageTest.java" ]
then
    echo There is no file named src/test/java/fbmessage/tests/MessageTest in the directory "$1"
    exit 1
fi

cd "$1" || exit
if [ ! -e log ]
then
    mkdir log
fi
./gradlew test --rerun-tasks >> log/log.txt