#!/bin/sh

for file in *.png
do
	zopflipng -m -y "$file" "$file"
done
