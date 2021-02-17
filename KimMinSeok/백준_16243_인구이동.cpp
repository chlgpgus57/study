#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <set>

using namespace std;

int n, l, r;
vector<vector<pair<int, vector<bool>>>> v(50);
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
int ans;

void input() {
	cin >> n >> l >> r;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++) {
			int num;
			cin >> num;
			vector<bool> vv(4, false);
			v[i].push_back({ num, vv });
		}
	}
}

void solve() {
	while (true) {
		bool flag = false;
		//통로 열고
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++) {
				for (int w = 0; w < 4; w++) {
					int nx = i + dx[w];
					int ny = j + dy[w];

					if (nx < 0 || nx >= n || ny < 0 || ny >= n)
						continue;

					int sub = abs(v[i][j].first - v[nx][ny].first);
					if (sub >= l && sub <= r) {
						v[i][j].second[w] = true;
					}
				}
			}
		}
		//이동
		bool visit[51][51] = { false, };
		queue<pair<int, int>> q;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++) {
				if (visit[i][j])
					continue;
				vector<pair<int, int>> all;
				q.push({ i,j });
				visit[i][j] = true;
				int allSum = 0;
				while (!q.empty()) {
					int x = q.front().first;
					int y = q.front().second;
					q.pop();
					allSum += v[x][y].first;
					all.push_back({ x,y });
					
					for (int w = 0; w < 4; w++) {
						int nx = x + dx[w];
						int ny = y + dy[w];
						if (nx < 0 || nx >= n || ny < 0 || ny >= n)
							continue;

						if (v[x][y].second[w] && !visit[nx][ny]) {
							visit[nx][ny] = true;	
							q.push({ nx,ny });
						}
					}
				}

				if (all.size() != 1) {
					for (int w = 0; w < all.size(); w++) {
						v[all[w].first][all[w].second].first = allSum / all.size();
						flag = true;
					}
				}
			}
		}

		if (!flag)
			break;

		ans++;

		//초기화
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++) {
				for (int w = 0; w < 4; w++) {
					v[i][j].second[w] = false;
				}
			}
		}	
	}
}

int main() {
	input();
	solve();
	cout << ans << endl;
	return 0;
}