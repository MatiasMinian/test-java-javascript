const second = 'second';
const seconds = 'seconds';
const minute = 'minute';
const minutes = 'minutes';
const hour = 'hour';
const hours = 'hours';
const ago = 'ago';

function timeAgoHandler(dateInMillis) {

    let timeAgo = (Date.now() - dateInMillis)/1000;

    let timeUnit = undefined;
    if (timeAgo < 60) {
        if (timeAgo == 1) {
            timeUnit = second;
        } else {
            timeUnit = seconds;
        }        
    } else if (timeAgo < 3600) {
        if (timeAgo == 60) {
            timeUnit = minute;
        } else {
            timeUnit = minutes;
        }
        timeAgo /= 60;
    } else {
        if (timeAgo == 3600) {
            timeUnit = hour;
        } else {
            timeUnit = hours;
        }
        timeAgo /= 3600;
    }

    timeAgo = Math.round(timeAgo);
    return timeAgo + ' ' + timeUnit + ' ' + ago;
}

export default timeAgoHandler;