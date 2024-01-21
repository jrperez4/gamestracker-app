  document.addEventListener("DOMContentLoaded", function () {
        $('.btn-black').on('click', function () {
            var gameSlug = $(this).data('game-slug');
            var detailsUrl = '/game-details/' + gameSlug;

            $.ajax({
                type: 'GET',
                url: detailsUrl,
                success: function (response) {

                    console.log(response);

                    $('#gameDetailsImage').attr('src', response.background_image_additional);

                    $('#gameDetailsTitle').text(response.name);
                    var highlightedDescription = highlightProperNouns(response.description);
                    $('#gameDetailsDescription').html(highlightedDescription);

                    if (response.developers && response.developers.length > 0) {
                        var developersNames = response.developers.map(function (developer) {
                            return developer.name;
                        }).join(', ');

                        $('#gameDetailsDevelopers').text('Developers: ' + developersNames);
                    } else {
                        $('#gameDetailsDevelopers').text('Developers: N/A');
                    }

                    $('#gameDetailsModal').modal('show');

                },
                error: function (error) {
                    console.error('Error retrieving game details:', error);
                }
            });
        });
    });

    $(document).ready(function () {
        $('#gameDetailsModal').on('show.bs.modal', function () {
            // Blocks the modal
            $(this).css('pointer-events', 'none');
        });

        // Executes while modal is hidden
        $('#gameDetailsModal').on('hidden.bs.modal', function () {
            // Unblock the while is hidden
            $(this).css('pointer-events', 'auto');
        });
    });

    function highlightProperNouns(text) {
        // Regular expression to find words that start with an uppercase letter,
        // excluding those following a period followed by a space
        var regex = /\b(?<!\. )\b[A-Z][a-z]*\b/g;

        // Replace matches with the bold highlighted version
        var highlightedText = text.replace(regex, function(match) {
            return '<strong>' + match + '</strong>';
        });

        return highlightedText;
    }