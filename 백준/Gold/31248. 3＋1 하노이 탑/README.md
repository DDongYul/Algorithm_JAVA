# [Gold III] 3+1 하노이 탑 - 31248 

[문제 링크](https://www.acmicpc.net/problem/31248) 

### 성능 요약

메모리: 31888 KB, 시간: 228 ms

### 분류

애드 혹, 재귀

### 제출 일자

2024년 2월 1일 10:59:25

### 문제 설명

<p>3+1 하노이 탑 게임은 가로 방향으로 일렬로 놓인 4개의 기둥과 크기가 서로 다른 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>개의 원판을 이용한 게임이다. 편의상 왼쪽에 있는 기둥부터 차례대로 A, B, C, D라고 하자.</p>

<p>처음에는 기둥 A에 크기가 가장 큰 원판이 아래에 오도록 모든 원판이 크기 순서대로 쌓여 있다. 이 게임의 목표는 아래 규칙을 지키면서 모든 원판을 기둥 D로 옮기는 것이다.</p>

<ul>
	<li>한 번에 1개의 원판만 옮길 수 있다.</li>
	<li>어떤 기둥의 맨 위에 있는 원판만 옮길 수 있다.</li>
	<li>작은 원판 위에 큰 원판을 놓을 수 없다.</li>
	<li><strong>기둥 D에 있는 원판을 다른 기둥으로 옮길 수 없다.</strong></li>
	<li>기둥 A, B, C에 있는 원판은 위 조건을 어기지 않는 한 자유롭게 옮길 수 있다.</li>
</ul>

<p>기둥 A에 있는 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>개의 원판을 모두 기둥 D으로 옮기기 위해 필요한 최소 이동 횟수를 구하고, 그러한 이동 방법을 아무거나 하나 출력하시오.</p>

### 입력 

 <p>첫 번째 줄에 정수 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>이 주어진다.</p>

### 출력 

 <p>첫 번째 줄에 원판을 모두 옮기기 위해 필요한 최소 이동 횟수 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>M</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$M$</span></mjx-container>을 출력한다.</p>

<p>다음 줄부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>M</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$M$</span></mjx-container>줄에 걸쳐서 한 줄에 원판의 이동을 하나씩 출력한다. 원판을 기둥 X에서 기둥 Y로 옮겼을 때 <code>X Y</code>의 형태로 출력한다.</p>

