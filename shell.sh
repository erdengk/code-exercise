now=$(date "+%Y-%m-%d-%H:%M")

git add ./
git commit -m "代码提交$now"
git push origin main

echo "上传完成"