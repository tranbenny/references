% creates a heatmap from rotating to one side of a 3-D plot

matrix = rand(50, 50); % generates 50x50 matrix of random numbers
surf(matrix);
view(0, 90);
colormap(flipud(gray)); % converts heatmap to grey scale

% plotting multiple plots onto one figure

figure
% parameters: x by y size, at position 1
subplot(2, 2, 1); 
surf(matrix);
view(0, 90);
title('title of first plot here');

subplot(2, 2, 2);
surf(matrix);
view(0, 90);
title('title of second plot here');