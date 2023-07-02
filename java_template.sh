#! /bin/zsh

problem_id=$1
echo "Generate template folder for new problem"

mkdir -p $1
cd $1
cp ../JavaSolutionTemplate Solution.java

sed -i.bak 's/problem/'${problem_id}'/g' Solution.java
sed -i.bak 's/SolutionTemplate/Solution/g' Solution.java

rm Solution.java.bak

